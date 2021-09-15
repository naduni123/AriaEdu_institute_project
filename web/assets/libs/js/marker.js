const toSubmit =()=>{

    if(document.getElementById("fname").value == "")
    {
        document.getElementById("fname").style.borderColor = "red";
        document.getElementById("result").innerHTML ="required";
        document.getElementById("result").style.color = "red";
        document.getElementById("labelfname").style.color = "red";
    }

}

function f() {

    alert('hello');

}