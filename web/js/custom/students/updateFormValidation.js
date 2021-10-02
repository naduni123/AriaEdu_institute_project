<!-- Update Validation Function-->
function studentValidation(){
    var address = document.forms["form"]["address"].value;
    var phone = document.forms["form"]["phone"].value;
    var email = document.forms["form"]["email"].value;
    var status = document.forms["form"]["status"].value;

    if (addressValidation(address)) {
        if (isNumeric(phone)) {
            if (emailValidation(email)) {
                if (statusValidation(status)) {
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }else {
        return false;
    }
}

<!-- Empty Validation -->
function isEmpty(elemValue, field) {
    if (elemValue == "" || elemValue == null) {
        document.getElementById('eEmpty').innerHTML="You cannot have " + field + "field empty";
        return true;
    } else {
        return false;
    }
}

<!-- Address Empty Validation -->
function addressValidation(elemValue) {
    if (!isEmpty(elemValue, "address")) {
        return true;
    } else {
        return false;
    }
}

<!-- Phone Number Validation -->
function isNumeric(elemValue) {
    if (!isEmpty(elemValue, "phone")) {
        var exp=/^[0-9]+$/;

        if (elemValue.match(exp)) {
            return true;
        } else {
            document.getElementById('ePhone').innerHTML="Enter a valid phone number";
            return false;
        }
    } else {
        return false;
    }
}

<!-- Email Validation -->
function emailValidation(elemValue) {
    if (!isEmpty(elemValue, "email")) {
        var atops = elemValue.indexOf("@");
        var dotops = elemValue.indexOf(".");

        if (atops < 1 || dotops+2 >= elemValue.length || atops+2 > dotops) {
            document.getElementById('eEmail').innerHTML="Enter a valid email";
            return false;
        } else{
            return true;
        }
    } else {
        return false;
    }
}

<!-- Batch Selection Validation -->
function statusValidation(elemValue) {
    if (elemValue == "Select Status") {
        document.getElementById('eStatus').innerHTML="Select Status";
        return false;
    } else {
        return true;
    }
}