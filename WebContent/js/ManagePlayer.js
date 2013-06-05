//უნდა გამოვიყენო მოთამაშის შესქმნელი გვერდისთვის

function addPlayerForm(){
	editPlayerCancel();
	document.getElementById("addPlayer").style.display = "block";
}
function addPlayerCancel(){
	document.getElementById("addPlayer").style.display = "none";
}
function editPlayerForm(){
	addPlayerCancel();
	document.getElementById("editPlayer").style.display = "block";
}
function editPlayerCancel(){
	document.getElementById("editPlayer").style.display = "none";
}
function show(){
	var selected = document.getElementById("player");
	var selectedIndex = selectedPlayer.selectedIndex;
	var selectedPlayer = selected[selectedIndex].text;
	document.getElementById("deo").innerHTML=selectedPlayer;
}