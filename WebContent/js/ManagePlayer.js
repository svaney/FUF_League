//უნდა გამოვიყენო მოთამაშის შესქმნელი გვერდისთვის

function addPlayerForm(){
	document.getElementById("addPlayer").style.display = "block";
}
function addPlayerCancel(){
	document.getElementById("addPlayer").style.display = "none";
}
function checkform ( form ){
	if(!geoInput((form.firstName.value))){
		form.firstName.focus();
		alert("მოთამაშის სახელი შეიყვანეთ ქართულ ენაზე და გამოიყენეთ მხოლოდ ასოები! \nჩვენ გვიყვარს ქართული <3");
		return false;
	}
	if(!geoInput((form.lastName.value))){
		form.firstName.focus();
		alert("მოთამაშის გვარი შეიყვანეთ ქართულ ენაზე და გამოიყენეთ მხოლოდ ასოები! \nჩვენ გვიყვარს ქართული <3");
		return false;
	}
	return confirm("გსურთ ცვლილებების შენახვა?");
}

function geoInput(input){
	if ( /^[ა-ჰ]+$/.test(input)) {
	    return true;
	}
	return false;
}
function georgianInput(input){
	for(var i = 0; i < input.lenght; i++){
		if((input[i]-'ა')<0 || ([i]-'ა')>33 )return false;
	}
	return true;
}