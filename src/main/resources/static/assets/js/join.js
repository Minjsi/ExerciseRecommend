let $uemail = $('input#email');
let $upw = $('input#password');
let $upw2 = $('input#password_check');
let emailPass = true;  // 테스트용으로 true
let pwPass = false;

//input에 keyup 이벤트 등록
$uemail.bind("change keyup input", function(){
    //keyup 이벤트 발생 시 해당 input의 value 가져오기.
    let $uemailval = $uemail.val();
    //실시간 검색이 필요한 table의 모든 행(tr) 숨김 처리
    if (!$uemailval) { // 아이디 입력칸이 비어 있을 경우
        $('span#emailCheck_text').empty().text("아이디를 입력해 주세요").css("color", "red");
        emailPass = false;
        return;
    }
    checkEmail();
});

// 이메일 유효성 검사
function checkEmail(){
    var email =  $('input#email').val();
    console.log(email);
    var exptext = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
    console.log(exptext.test(email));
    if(!exptext.test(email)) {
        //이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
        $('span#emailCheck_text').empty().text("이메일 형식이 아닙니다.").css("color", "red");
        $('input#email').focus();
        $('#emailCheck').attr('disabled', true);
        return false;
    }

    $('span#emailCheck_text').empty().text("올바른 이메일 형식입니다.").css("color", "green");
    $('#emailCheck').attr('disabled', false);
    emailPass = true;
}


$("#emailCheck").on("click",function () {
    let $uemailval = $uemail.val();
    joinService.emailCheck($uemailval,function (result) {
        if (result===0) {
            console.log(result);
            $('span#emailCheck_text').empty().text("사용 가능한 아이디 입니다.").css("color", "green");
            emailPass = true;
        } else {
            $('span#emailCheck_text').empty().text("이미 사용 중인 아이디 입니다.").css("color", "red");
            emailPass = false;
        }
    });
});


// 비밀번호 유효성검사
function checkPw(){
    if($("input#password").val().length < 8){
        $('span#pwCheck_text_first').text("8자 이상 입력해주세요").css("color", "red");
        $('span#pwCheck_text').text(" ").css("color", "red");
    }else{
        $('span#pwCheck_text_first').text("가능한 비밀번호 형식입니다").css("color", "green");
    }
}

// 비밀번호 유효성 검사 적용
$upw.blur(function () {
    checkPw();
})

// 비밀번호 확인검사
$upw2.blur(function () {
    let $upwval = $upw.val();
    let $upw2val = $upw2.val();
    if (!$upwval || !$upw2val) {
        $('span#pwCheck_text').text("비밀번호를 입력해주세요").css("color", "red");
        pwPass = false;
        return;
    }else if($("input#password").val().length < 8){
        $('span#pwCheck_text').text("선 비밀번호 조건이 맞지 안습니다").css("color", "red");
    }else if ($upwval != $upw2val) {
        $('span#pwCheck_text').text("비밀번호가 일치하지 않습니다").css("color", "red");
        pwPass = false;
        return;
    } else {
        $('span#pwCheck_text').empty().text("비밀번호가 일치합니다.").css("color", "green");
        pwPass = true;
    }
});


// 가입하기
$("#submit-user").on("click", function () {
    if (!emailPass) {
        alert("이메일을 다시 확인해주세요");
        return false;
    } else if (!pwPass) {
        alert("비밀번호를 다시 확인해주세요")
        return false;
    }else {
        //비밀번호 암호화
        let enpw=btoa($('input[name=pw]').val());
        $('input[name=pw]').val(enpw);

        console.log($('input[name=pw]').val())

        joinForm.submit();
        alert("환영합니다. 회원가입이 완료되었습니다.");
    }
})

//모듈화-가독성과 재사용성
let joinService=(function () {

    function emailCheck(uemailval,callback,error) {
        $.ajax({
            url: "/userR/emailMatching",
            type: "post",
            data: {email: uemailval},
            success: function (result) {
                if(callback){
                    callback(result);
                }
            },
            error: function (xhr, status, er) {
                if(error){
                    error(xhr, status, er);
                }
                console.log(xhr, status, er);
            }
        })
    }


    return{
        emailCheck:emailCheck
    }
})();

