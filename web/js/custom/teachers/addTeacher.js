$(function() {
    $("#f_name").focus().select();
    //enter key press event
    $(document).keypress(function (e) { //comes here in every key press
        if (e.which === 13) { // check if it is 'enter'
            e.preventDefault();			//go down when enter is pressed
            if (e.target.id === 'f_name') {
                if (validateRequired('f_name')) { //validation.js
                    $("#l_name").focus().select();
                }
            }else if(e.target.id === 'l_name'){
                if (validateRequired('l_name')) {
                    $("#full_name").focus().select();
                }
            }else if(e.target.id === 'full_name'){
                if (validateRequired('full_name')) {
                    $("#nic").focus().select();
                }
            }else if(e.target.id === 'nic'){
                if (validateRequired('nic')) {
                    $("#address").focus().select();
                }
            }else if(e.target.id === 'address'){
                if (validateRequired('address')) {
                    $("#phone-mask").focus().select();
                }
            }else if(e.target.id === 'phone-mask'){
                if (validateRequired('phone-mask')) {
                    $("#email-mask").focus().select();
                }
            }else if(e.target.id === 'email-mask'){
                if (validateRequired('email-mask')) {
                    validateSubmit(e);
                }
            }
        }
    });
});

//on clicking the submit button

const validateSubmit = (event) => {
    event.preventDefault();
    console.log("Validate began");
    let err = 0;

    if(!validateRequired('f_name')){
        validateRequired('f_name');
        err++;
    }

    if(!validateRequired('l_name')){
        validateRequired('l_name');
        err++;
    }

    if(!validateRequired('full_name')){
        validateRequired('full_name');
        err++;
    }

    if(!validateRequired('nic')){
        validateRequired('nic');
        err++;
    }

    if(!validateRequired('address')){
        validateRequired('address');
        err++;
    }

    if(!validateRequired('phone-mask')){
        validateRequired('phone-mask');
        err++;
    }

    if(!validateRequired('email-mask')){
        validateRequired('email-mask');
        err++;
    }


    if(err == 0){ //if no errors
        addTeacher(event);
    }else{
        return false;
    }
}

//add teacher details

const addTeacher = (event) => {
    event.preventDefault();

    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, Save it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $("#submitBtn").prop("disabled", true);
            const f_name = $("#f_name").val();
            const l_name = $("#l_name").val();
            const full_name = $("#full_name").val();
            let gender="Female";
            if ($("#male").prop("checked")) { //check if male radio button is marked
                gender="Male";
            }
            const nic = $("#nic").val();
            const address = $("#address").val();
            const phone = $("#phone-mask").val();
            const email = $("#email-mask").val();
            const subject = $("#subject").val();

            $.ajax({
                type: "POST",
                url: "/web_war_exploded/AddTeacherController?action=add&f_name="+f_name+"&l_name="+l_name+"&full_name="+full_name
                    +"&gender="+gender+"&nic="+nic+"&address="+address+"&phone="+phone+"&email="+email+"&subject="+subject,
                headers : {
                    Accept : "application/json; charset=utf-8",
                    "Content-Type" : "application/json; charset=utf-8"
                },
                success: function (data) {
                    if(addTeacherQualification(data)){
                        Swal.fire(
                            'Successful!',
                            'Teacher Details Saved!',
                            'success'
                        )
                        clearForm();
                    }else{
                        Swal.fire(
                            'Error!',
                            'Unable to save!',
                            'error'
                        );
                    }


                    $("#submitBtn").prop("disabled", false);
                }
            });
        }
    })
};

const addTeacherQualification = (data) => {
    let teacherQualifications = new Array();
    let error = 0;
    $('#tblQualifications > tbody > tr').each(function (row, tr) {
        teacherQualifications[row] = {
            "teacherId": data
            , "qualification": $(tr).find('td:eq(0) input').val()
        };
    });

    //for each works as the length of the array
    $.each(teacherQualifications, function (i, teacherQualification) {
        $.ajax({
            type: "POST",
            url: "/web_war_exploded/AddTeacherController?action=addTeacherQualification&id="+teacherQualification.teacherId+"&qualification="+teacherQualification.qualification,
            success: function (data) {
                if(!data){
                    error++;
                }
            }
        });
    });


    if(error > 0){
        return false;
    }

    return true;
};

const clearForm = () => {
    $("#addTeacherForm").trigger('reset');
    $("#tblQualifications > tbody").find("tr").remove();
};

function demo(){
    $("#fullName").val("Modeesha Kalani Priyanka");
    $("#firstName").val("Modeesha");
    $("#lastName").val("Kalani");
    $("#gender").val("Female").change();;
    $("#dob").val("1997-12-23");
    $("#address").val("No:66,Godigamuwa,Gonpola");
    $("#guardian").val("Tudor Weerasinghe");
    $("#cNumber").val("0764771140");
    $("#occupation").val("Businessmen");
    $("#addmissionDate").val("2021-05-07");
    $("#admissionNo").val("S002");
}

const addToQualificationTable = (event) => {
    event.preventDefault();
    const dip = $('#input-select').val();

    if (dip == "") {
        Swal.fire(
            'Error!',
            'Please add your qualification !',
            'error'
        );
    } else {

        const id = dip.replace(/[^a-z0-9\s]/gi, '').replace(/\s/g, "");

        let isExsist = false;

        if ($('#tblQualifications > tbody').find('#' + id).length > 0) {
            isExsist = true;
        }

        if (!isExsist) {
            addRow(id);
        }else{
            console.log("else state!");
        }

        $('#subject' + id).val(dip);

        $('#tblQualifications >tbody >tr').find('.iteminsert').val('');
    }
};

const addRow = (id) => {
    let text = "";
    $('#tblQualifications tbody').append('<tr id="' + id + '"><td class="td-input">'
        + '<input  type="text" id="subject' + id + '" name="subject' + id + '" class="form-control" readonly >'
        + '</td>'
        + '</td>'
        + '<td class="text-center" id="deleteRow' + id + '" onclick="removeFromTables(this.id);" ><span class="fas fa-window-close" style="color:red;cursor: pointer"></span>'
        + '</td>'
        + '</tr>');
}

const removeFromTables = (id) => {
    $("#" + id).parent().remove();
};