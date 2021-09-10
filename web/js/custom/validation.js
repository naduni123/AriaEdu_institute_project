
// Validations 
// Validate Dropdown
function validateDropdown(x) {
    if (document.getElementById(x).selectedIndex !== 0) {
        document.getElementById(x).style.background = '#ffffff';
        $('#' + x).next().find('.select2-selection').css('background', '#ffffff');
        return true;
    } else {
        document.getElementById(x).style.background = '#ffcccc';
        $('#' + x).next().find('.select2-selection').css('background', '#ffcccc');
        return false;
    }
}
// Validate Text
function validateText(x) {
    var re = /^(\w+\s)*\w+$/;
    if (document.getElementById(x).value === "") {
        document.getElementById(x).style.background = '#ffcccc';
//        $('#' + x).prop('title', 'field cannot be empty');
//        $('#' + x).tooltip('show');
        return false;
    } else if (!re.test(document.getElementById(x).value)) {
        document.getElementById(x).style.background = '#ffcccc';
//        $('#' + x).prop('title', 'enter a valid text');
//        $('#' + x).tooltip('show');
        return false;
    } else {
        document.getElementById(x).style.background = '#ffffff';
//        $('#' + x).prop('title', '');
//        $('#' + x).tooltip('destroy');
        return true;
    }
}

// Validate Date
function validateDate(x) {
    if (document.getElementById(x).value === "") {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    } else {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    }
}

// Validate NIC
function validateNIC(x) {
    var re = /^[0-9]{9}[VX]$/;
    var re2 = /^[0-9]{12}$/;
    if (!re.test(document.getElementById(x).value) && !re2.test(document.getElementById(x).value)) {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    } else {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    }
}

function validateRequired(x) {
    if (document.getElementById(x).value === "") {
        document.getElementById(x).style.background = '#ffcccc';
//        $('#'+x).find('*').style.background('#ffcccc');
        return false;
    } else {
        document.getElementById(x).style.background = '#ffffff';
//        $('#'+x).find('*').style.background('#ffffff');
        return true;
    }
}

function validateTel(x) {
    var re = /^[0][0-9]{9}$/;
    if (document.getElementById(x).value === "") {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    } else if (!re.test(document.getElementById(x).value)) {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    } else {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    }
}

function validateTelNotReq(x) {
    var re = /^[0][0-9]{9}$/;
    if (document.getElementById(x).value === "") {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    } else if (!re.test(document.getElementById(x).value)) {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    } else {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    }
}


function validateEmail(x) {
    var re = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (document.getElementById(x).value === "") {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    } else if (!re.test(document.getElementById(x).value)) {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    } else {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    }
}

function validateRetypePassword(x) {
    if (document.getElementById(x).value === document.getElementById('password').value) {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    } else {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    }
}

function validateConfirmPassword(x, y) {
    if (document.getElementById(x).value === document.getElementById(y).value) {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    } else {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    }
}

function validateNumber(x) {
    var number = Number(document.getElementById(x).value);
    if (number > 0) {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    } else {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    }
}
function validateMoney(x) {
    var number = Number(document.getElementById(x).value);
    if (number > 0) {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    } else {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    }
}
function validateInteger(x) {
    var number = document.getElementById(x).value;
    if (isNumeric(number)) {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    } else {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    }
}
function validateIntegerPN(x) {
    var number = document.getElementById(x).value;
    if (isNumeric(number)) {
        document.getElementById(x).style.background = '#ffffff';
        return true;
    } else {
        document.getElementById(x).style.background = '#ffcccc';
        return false;
    }
}

function validateTable(tableId) {
    var rowCount = $('#' + tableId + ' >tbody >tr').length;
//    alert(rowCount);
    if (rowCount > 1) {
        return true;
    } else {
        return false;
    }
}

function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}

function validateDateRangeFrom(f, t) {
    var from = $('#' + f).val();
    var to = $('#' + t).val();
    console.log(from + ' ' + to);
    $('#' + t).prop('min', from);
    date1 = new Date(from);
    date2 = new Date(to);
    if (to === '' || date1 > date2) {
        $('#' + t).val(from);
    }
}

function validateDateRangeTo(f, t) {
    var from = $('#' + f).val();
    var to = $('#' + t).val();
    console.log(from + ' ' + to);
    $('#' + f).prop('max', to);
    date1 = new Date(from);
    date2 = new Date(to);
    if (from === '' || date1 > date2) {
        $('#' + f).val(to);
    }
}
