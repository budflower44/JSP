console.log("board_detail.js in~!!");
console.log(bnoVal);
console.log(id);

//컨트롤러에서 리스트 달라고 요청
async function getCommentListFromServer(bno){
    try {
        const resp = await fetch("/cmt/list/"+bno); //cmt/list/349
        const result = await resp.json(); //[{...}, {...}, {...}]
        console.log(result);
        return result;
    } catch (error) {
        console.log(error);
    }
}

//list 뿌려오는 거
function spreadCommentList(result){
    console.log(result);
    let div = document.getElementById('commentLine');
    div.innerHTML = ""; //원래 만들어뒀던 구조 지우기
    for(let i=0; i<result.length; i++){
        let html = `<div>`;
        html += `<div>${result[i].cno}, ${result[i].bno}, ${result[i].writer}, ${result[i].regdate}</div>`;
        html += `<div>`;
        if(id==result[i].writer){
            html += `<button type="button" data-cno="${result[i].cno}" class="cmtModBtn btn btn-primary">수정</button>`;
            html += `<button type="button" data-cno="${result[i].cno}" class="cmtDelBtn btn btn-danger">삭제</button>`;
        }
        html += `<div><input type="text" class="cmtText form-control" value="${result[i].content}"></div>`;
        html += `<hr>`;
        html += `</div></div>`;
        div.innerHTML += html; //각 댓글 객체를 누적해서 담기
    }
}

function printCommentList(bno){
    getCommentListFromServer(bno).then(result => { //cmtList
        console.log(result);
        if(result.length>0){
            spreadCommentList(result);
        }else{
            let div = document.getElementById("commentLine");
            div.innerHTML = `<div>comment가 없습니다.</div>`;
        }
    })
}


document.getElementById("cmtAddBtn").addEventListener('click', ()=>{
    const cmtText = document.getElementById('cmtText').value;
    if(cmtText == null || cmtText == ''){
        alert('댓글을 입력해주세요.');
        return false;
    }else{
        //댓글등록
        let cmtData = {
            bno : bnoVal,
            writer : document.getElementById('cmtWriter').value,
            content : cmtText
        };
        //댓글 등록 비동기 통신 호출
        postCommentToServer(cmtData).then(result =>{
            console.log(result);
            if(result>0){
                alert('댓글 등록 성공~!!');
                //입력된 댓글 지우기
                document.getElementById("cmtText").value = "";
            }
            //댓글 출력
            printCommentList(bnoVal);
        })
    }

})

async function postCommentToServer(cmtData){
    try {
        const url = "/cmt/post";
        const config = {
            //method, headers, body
            method : 'post', 
            headers: {
                'Content-Type' : 'application/json; charset=utf-8'
            }, 
            body: JSON.stringify(cmtData)
        };

        const resp = await fetch(url, config);
        const result = await resp.text(); //isOk 값을 리턴
        return result;
    } catch (error) {
        console.log(error);
    }
}

//댓글 수정(비동기통신) : cno, content => result isOk
async function updateCommentFromServer(cnoVal, cmtText){
    try {
        const url = "cmt/modify";
        const config = {
            method: 'post', 
            headers:{
                'Content-Type' : 'application/json; charset=utf-8'
            },
            body : JSON.stringify({cno:cnoVal, content:cmtText})
        }

        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

//삭제(비동기 통신) : cno => result isOk
async function removeCommentFromServer(cno){
    try {
        const url = "/cmt/remove?cnoVal="+cno;
        const resp = await fetch(url);
        const result = resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.addEventListener('click', (e)=>{
    console.log(e.target);
    //삭제버튼이 클릭되면... 수정버튼이 클릭되면...
    if(e.target.classList.contains('cmtDelBtn')){
        let cnoVal = e.target.dataset.cno; //data-cno의 값을 추출
        console.log(cnoVal);
        removeCommentFromServer(cnoVal).then(result => {
            //result = isOk
            if(result > 0){
                alert('댓글 삭제 성공~!!');
                printCommentList(bnoVal);
            }
        })
    }
    //수정버튼이 클릭되면...
    if(e.target.classList.contains('cmtModBtn')){
        let cnoVal = e.target.dataset.cno;
        console.log(cnoVal);
        let div = e.target.closest('div'); //타겟을 기준으로 가장 가까운 div 찾기
        let cmtText = div.querySelector('.cmtText').value;
        console.log(cmtText);

        updateCommentFromServer(cnoVal, cmtText).then(result=>{
            //isOk
            console.log(result);
            if(result>0){
                alert('댓글 수정 성공~!!');
                //댓글 출력
                printCommentList(bnoVal);
            }
        })
    }
})