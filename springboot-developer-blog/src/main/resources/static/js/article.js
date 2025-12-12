// 삭제 코드는 자바스크립트로 작성
// 삭제 API로 요청을 보낼 코드를 작성

// 삭제 기능
const deleteButton = document.getElementById('delete-btn')

if(deleteButton) {
    deleteButton.addEventListener('click', event => {
    let id = document.getElementById('article-id').value;
    fetch(`/api/articles/${id}`, {
        method: 'DELETE'
    })
    .then(() => {
        alert('삭제가 완료되었습니다.');
        location.replace('/articles');
    });
    });
}

// 수정 기능
// 1. id가 modify-btn인 엘리먼트 조회
const modifyButton = document.getElementById('modify-btn');

if (modifyButton) {
    // 2. 클릭 이벤트가 감지되면 수정 API 요청
    modifyButton.addEventListener('click', event => {
    let params = new URLSearchParams(location.search);
    let id = params.get('id');

    fetch(`/api/articles/${id}`, {
        method: 'PUT',
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            title: document.getElementById('title').value,
            content: document.getElementById('content').value
        })
    })
    .then(() => {
        alret('수정이 완료되었습니다.');
        location.replace(`/articles/${id}`);
    });
    });
}

// 등록 기능
// [등록] 버튼을 누르면 입력 칸에 있는 데이터를 가져와 게시글 생성 API에 글 생성 관련 요청을 보내주는 코드
// id가 create-btn인 엘리먼트
const createButton = document.getElementById("create-btn");
if (createButton) {
    // 클릭 이벤트가 감지되면 생성 API 요청
    createButton.addEventListener("click", (event) => {
        fetch("/api/articles", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById("title").value,
                content: document.getElementById("content").value,
            }),
        }).then(() => {
            alert("등록 완료되었습니다.");
            location.replace("/articles");
        });
    });
}