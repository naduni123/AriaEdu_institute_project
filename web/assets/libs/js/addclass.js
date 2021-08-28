function validateform(){

    let isnameok = classnamevalidation();
    let isfloorok =floorvalidation();
    let iscapacityok =capacityvalidation();
    let isacok =featurevalidation();



    if(isnameok==true && isfloorok==true && iscapacityok == true && isacok == true ){
        return true;
    }else{
        return false;
    }




}

function reset() {

    document.getElementById('name').value="";
    document.getElementById('floor').value="";
    document.getElementById('capacity').value="0";
    document.getElementById('ac').value="";
}

function classnamevalidation(){

    let classname = document.forms['form']['name'].value;


    if(classname==""){

       document.getElementById('namecheck').innerHTML="please fill first name";
        return false;

    }else{
        return  true;
    }

}

function floorvalidation() {

    let floor = document.forms['form']['floor'].value;

    if(floor==""){

        document.getElementById('floorcheck').innerHTML="**please fill the floor name";
        return false;

    }else{
        return  true;
    }

}

function capacityvalidation() {

    let capacity = document.forms['form']['capacity'].value;

    if(capacity==""){

        document.getElementById('capacitycheck').innerHTML="**please fill the capacity";
        return false;

    }else{
        return  true;
    }

}

function featurevalidation() {

    let ac = document.forms['form']['ac'].value;

    if(ac==""){

        document.getElementById('acheck').innerHTML="**please fill the feature";
        return false;

    }else{
        return  true;
    }

}