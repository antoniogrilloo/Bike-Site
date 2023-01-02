function cambiaValoreSelect(x) {
	var t = document.getElementById("g");
	var t2 = document.getElementById("c");
	var t3 = document.getElementById("mb");
	if (x == "MountainBike"){	
		t.style.display = "none";
		t2.style.display = "none";
		t3.style.display = "block";	
	} else if (x == "Corsa"){
		t.style.display = "none";
		t2.style.display = "block";
		t3.style.display = "none";
	} else if (x == "Gravel"){
		t.style.display = "block";
		t2.style.display = "none";
		t3.style.display = "none";
	}
}

var t = document.getElementById("g");
t.style.display = "none";
t = document.getElementById("c");
t.style.display = "none";

var select = document.getElementById("dtype");
select.addEventListener("change", function () {
	cambiaValoreSelect(select.value)
});


