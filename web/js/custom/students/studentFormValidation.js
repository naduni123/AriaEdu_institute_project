<!-- Validation Function -->
function studentValidation(){
    var firstName = document.forms["form"]["firstName"].value;
    var lastName = document.forms["form"]["lastName"].value;
    var dob = document.forms["form"]["dob"].value;
    var nic = document.forms["form"]["nic"].value;
    var address = document.forms["form"]["address"].value;
    var gender = document.forms["form"]["gender"].value;
    var phone = document.forms["form"]["phone"].value;
    var email = document.forms["form"]["email"].value;
    var admissionDate = document.forms["form"]["admissionDate"].value;
    var batch = document.forms["form"]["batch"].value;
    var subjectOne = document.getElementById("subjectOne");
    var subjectTwo = document.getElementById("subjectTwo");
    var subjectThree = document.getElementById("subjectThree");
    var subjectFour = document.getElementById("subjectFour");

    if (isAlphebatic1(firstName)) {
        if (isAlphebatic(lastName)) {
            if (dobValidation(dob)) {
                if (validateNIC(nic)) {
                    if (addressValidation(address)) {
                        if (genderValidation(gender)) {
                            if (isNumeric(phone)) {
                                if (emailValidation(email)) {
                                    if (adDateValidation(admissionDate)) {
                                        if (batchValidation(batch)) {
                                            if ((subjectOne.checked)||(subjectTwo.checked)||(subjectThree.checked)||(subjectFour.checked)) {
                                                return true;
                                            } else {
                                                document.getElementById('eSubject').innerHTML="Select a Subject or Subjects";
                                                return false;
                                            }
                                        } else {
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

<!-- First Name Validation -->
function isAlphebatic1(elemValue) {
    var exp = /^[a-zA-Z]+$/;
    if (!isEmpty(elemValue, "firstName")) {
        if (elemValue.match(exp)) {
            return true;
        } else {
            document.getElementById('eFirstName').innerHTML="Enter only text for you first name";
            return false;
        }
    } else {
        return false;
    }
}

<!-- Last Name Validation -->
function isAlphebatic(elemValue) {
    var exp = /^[a-zA-Z]+$/;
    if (!isEmpty(elemValue, "lastName")) {
        if (elemValue.match(exp)) {
            return true;
        } else {
            document.getElementById('eLastName').innerHTML="Enter only text for you last name";
            return false;
        }
    } else {
        return false;
    }
}

<!-- DOB Empty Validation -->
function dobValidation(elemValue) {
    if (!isEmpty(elemValue, "dob")) {
        return true;
    } else {
        return false;
    }
}

<!-- NIC Validation -->
function validateNIC(elemValue) {
    if (!isEmpty(elemValue, "nic")) {
        var cnic_no_regex = new RegExp('^[0-9+]{9}[vV|xX]$');
        var new_cnic_no_regex = new RegExp('^[0-9+]{12}$');
        if (elemValue.length == 10 && cnic_no_regex.test(elemValue)) {
            return true;
        } else if (elemValue.length == 12 && new_cnic_no_regex.test(elemValue)) {
            return true;
        } else {
            document.getElementById('eNic').innerHTML="Enter a valid NIC number";
            return false;
        }
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

<!-- Gender Empty Validation -->
function genderValidation(elemValue) {
    if (!isEmpty(elemValue, "gender")) {
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

<!-- Admission Date Empty Validation -->
function adDateValidation(elemValue) {
    if (!isEmpty(elemValue, "admissionDate")) {
        return true;
    } else {
        return false;
    }
}

<!-- Batch Selection Validation -->
function batchValidation(elemValue) {
    if (elemValue == "Select Batch") {
        document.getElementById('eBatch').innerHTML="Select Batch";
        return false;
    } else {
        return true;
    }
}

<!-- Reset Function -->
function clearFields() {
    document.getElementById("firstName").value="";
    document.getElementById("lastName").value="";
    document.getElementById("dob").value="";
    document.getElementById("nic").value="";
    document.getElementById("address").value="";
    document.getElementById("gender").checked = false;
    document.getElementById("phone").value="";
    document.getElementById("email").value="";
    document.getElementById("admissionDate").value="";
    document.getElementById("batch").value="Select a Batch";
    document.getElementById("subjectOne").checked = false;
    document.getElementById("subjectTwo").checked = false;
    document.getElementById("subjectThree").checked = false;
    document.getElementById("subjectFour").checked = false;
}