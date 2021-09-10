$(function() {
    getTeachers(); //every time the page loads
});

const getTeachers = () => {
    const txt = $("#txt").val();
    const subject = $("#sub").val();
    const status = $("#status").val();
    $.ajax({
        type: "POST",
        url: "/web_war_exploded/AddTeacherController?action=get&txt="+txt+"&subject="+subject+"&status="+status,//&txt="+txt+"&search_opt="+search_opt+"&grade="+grade+"&class_name="+class_name+"&check_status="+check_status
        headers : {
            Accept : "application/json; charset=utf-8",
            "Content-Type" : "application/json; charset=utf-8"
        },
        //success function
        success: function (data) {
            $('#tblViewTeachers > tbody').html(''); //clear all data
            $.each(data, function (i, teacher) { //loop for all rows
                appendTeacherTable(teacher); //below function
            });
        }
    });
}

const appendTeacherTable = (item) => { //get data from teacher class
    let textToInsert = '';
    textToInsert += addRow(item);
    $('#tblViewTeachers > tbody').append(textToInsert);
};

//seperated to 3 because it was needed to add into tbody

const addRow = (item) => {
    const statusChangeBtn = '<button type="button" class="btn btn-info btn-xs" id="' + item.id + 'changeStatus" onclick="changeStatus(\'' + item.id + '\',\'' + item.status + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Change Status</button>';
    const delete_btn = '<button type="button" class="btn btn-danger btn-xs" id="' + item.id + 'delete" onclick="deleteTeacher(\'' + item.id + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Delete Student</button>';
    const update_btn = '<button type="button" class="btn btn-primary btn-xs" id="' + item.id + 'delete" onclick="updateTeacher(\'' + item.id + '\',\'' + item.f_name + '\',\'' + item.l_name + '\',\'' + item.full_name + '\',\'' + item.address + '\',\'' + item.email + '\',\'' + item.subject + '\')" data-toggle=\'modal\' data-target=\'#ModalAdd\'><span class="fas fa-trash-alt"></span>&nbsp;Update Teacher</button>';

    let statusBadge;
    if(item.status == 1){ //get status from student class using item
        statusBadge = '<span class="badge badge-success">Current</span>' //if status is active show green sign
    }else{
        statusBadge = '<span class="badge badge-danger">Past</span>'
    }

    let row = '<tr id="' + item.id + '">'
        + '<td>' + item.full_name + '</td>'
        + '<td>' + item.gender + '</td>'
        + '<td>' + item.contact_no + '</td>'
        + '<td>' + item.nic + '</td>'
        + '<td>' + statusBadge + '</td>'
        + '<td>'
        + statusChangeBtn
        + '</td>'
        + '<td>'
        + update_btn
        + '</td>'
        + '<td>'
        + delete_btn
        + '</td>'
        + '</tr>';
    return row;
};

const changeStatus = (id, status) => {
    console.log(id);
    console.log(status);
    $("#"+id+"changeStatus").prop("disabled", true);
    Swal.fire({
        title: 'Are you sure?',
        text: "Do you want to change status?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, proceed!'
    }).then((result) => {
        if (result.value) {
            $.ajax({
                type: "POST",
                url: "/web_war_exploded/AddTeacherController?action=update&id="+id+"&status="+status,
                headers : {
                    Accept : "application/json; charset=utf-8",
                    "Content-Type" : "application/json; charset=utf-8"
                },
                success: function (data) {
                    if(data){
                        getTeachers();
                    }
                }
            });
            $("#"+id+"changeStatus").prop("disabled", false);
        }else{
            $("#"+id+"changeStatus").prop("disabled", false);
        }
    })
};

const deleteTeacher = (id) => {
    console.log(id);
    console.log(status);
    $("#"+id+"changeStatus").prop("disabled", true);
    Swal.fire({
        title: 'Are you sure?',
        text: "Do you want to delete ?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, proceed!'
    }).then((result) => {
        if (result.value) {
            $.ajax({
                type: "POST",
                url: "/web_war_exploded/AddTeacherController?action=delete&id="+id,
                headers : {
                    Accept : "application/json; charset=utf-8",
                    "Content-Type" : "application/json; charset=utf-8"
                },
                success: function (data) {
                    if(data){
                        getTeachers();
                    }
                }
            });
            $("#"+id+"changeStatus").prop("disabled", false);
        }else{
            $("#"+id+"changeStatus").prop("disabled", false);
        }
    })
};


const updateTeacher = (id,f_name,l_name,full_name,address,email,subject) => {
    //set all the details
    $("#id_customer").val(id);
    $("#first_name").val(f_name);
    $("#last_name").val(l_name);
    $("#full_name").val(full_name);
    $("#address").val(address);
    $("#email-mask").val(email);
    $("#subject").val(subject);
};

const update_teacher = (event) => {
    event.preventDefault();

    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, Update it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $("#submitBtn").prop("disabled", true);
            const id = $("#id_customer").val();
            const f_name = $("#first_name").val();
            const l_name = $("#last_name").val();
            const full_name = $("#full_name").val();
            const address = $("#address").val();
            const email = $("#email-mask").val();
            const subject = $("#subject").val();

            $.ajax({
                type: "POST",
                url: "/web_war_exploded/AddTeacherController?action=update_teacher&f_name="+f_name+"&l_name="+l_name+"&full_name="+full_name
                    +"&address="+address+"&email="+email+"&subject="+subject+"&id="+id,
                success: function (data) {
                    window.location.reload(); //reload page
                }
            });
        }
    })
};
