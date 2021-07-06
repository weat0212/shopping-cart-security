function validateForm(form){
    if (!checkEmail(form.email.value) && !checkEmail(form.confirmEmail.value)){
        alert("Email 資料有誤，表單將不送出！");
        return false;
    } else {
        form.submit();
        return true;
    }

}

function checkEmail(email){
    let index = email.indexOf('@', 0);		// 尋找 @ 的位置，0 代表開始尋找的起始位置
    if (email.length===0) {
        alert("請輸入電子郵件地址！");
        return false;
    } else if (index===-1) {
        alert("錯誤：必須包含「@」。");
        return false;
    } else if (index===0) {
        alert("錯誤：「@」之前不可為空字串。");
        return false;
    } else if (index===email.length-1) {
        alert("錯誤：「@」之後不可為空字串。");
        return false;
    } else
        return true;
}