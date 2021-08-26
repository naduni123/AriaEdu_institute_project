function validateform(){

    let isbatchok = batchvalidate();
    let isdateok = dayvalidate();
    let isstartok =startvalidate();
    let isendok = endvalidate();
    let issubjectok = subjectvalidate();
    let isteacherok = teachervalidate();
    let isclassok = classvalidate();

    if(isbatchok == true && isdateok == true && isstartok == true && isendok==true && issubjectok==true && isteacherok==true && isclassok == true){

        return true;
    }else{
        return false
    }


}

function batchvalidate(){

    let batch = document.forms['form']['batch'].value;

    if(batch=="0"){

        document.getElementById('batchcheck').innerHTML="please select a batch";
        return false;

    }else{
        return  true;
    }

}

function dayvalidate(){

    let day= document.forms['form']['day'].value;

    if(day=="0"){

        document.getElementById('daycheck').innerHTML="please select a day";
        return false;

    }else{
        return  true;
    }

}

function startvalidate(){

    let start= document.forms['form']['starttime'].value;

    if(start==""){

        document.getElementById('starttimecheck').innerHTML="please enter start time";
        return false;

    }else{
        return  true;
    }

}

function endvalidate(){

    let end= document.forms['form']['endtime'].value;
    let start= document.forms['form']['starttime'].value;

    if(end==""){

        document.getElementById('endtimecheck').innerHTML="please enter end time";
        return false;

    }else if(end< start){
        document.getElementById('endtimecheck').innerHTML=" end time should greater than start time";
        return  false;
    }else{

        return true;
    }

}



function subjectvalidate(){

    let subject= document.forms['form']['subject'].value;

    if(subject=="0"){

        document.getElementById('subjectcheck').innerHTML="please select a subject";
        return false;

    }else{
        return  true;
    }

}

function teachervalidate(){

    let teacher= document.forms['form']['teacher'].value;

    if(teacher=="0"){

        document.getElementById('teachercheck').innerHTML="please select a teacher";
        return false;

    }else{
        return  true;
    }

}

function classvalidate(){

    let classroom= document.forms['form']['classroom'].value;

    if(classroom=="0"){

        document.getElementById('classroomcheck').innerHTML="please select a class";
        return false;

    }else{
        return  true;
    }

}

function reset(){
    document.getElementById('batch').innerHTML="";
    document.getElementById('day').innerHTML="";
    document.getElementById('starttime').innerHTML="";
    document.getElementById('endtime').innerHTML="";
    document.getElementById('teacher').innerHTML="";
    document.getElementById('subject').innerHTML="";
    document.getElementById('classroom').innerHTML="";

}