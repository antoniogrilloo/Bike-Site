var t = document.getElementById("g");
	t.style.display = "none";
	var t = document.getElementById("c");
	t.style.display = "none";
	
	function myFunction() {
		var x = document.getElementById("dinForm").value;
		var t = document.getElementById("g");
		var t2 = document.getElementById("c");
		var t3 = document.getElementById("mb");
		if (x == "MOUNTAIN-BIKE"){	
			t.style.display = "none";
			t2.style.display = "none";
			t3.style.display = "block";	
		} else if (x == "CORSA"){
			t.style.display = "none";
			t2.style.display = "block";
			t3.style.display = "none";
		} else if (x == "GRAVEL"){
			t.style.display = "block";
			t2.style.display = "none";
			t3.style.display = "none";
		}
	}