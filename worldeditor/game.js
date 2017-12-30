var grid = [];

var reader;

function setup() {   	
	reader = new FileReader();
	reader.onload = function (progressEvent) {
		importClassDiagramFromJSON(this.result);
	};

	createCanvas(1200, 700);
}

function draw() {	
	background(200);

}

function newFile() {
	var file = document.getElementById('file-input').files[0];
	reader.readAsText(file);
}

function importClassDiagramFromJSON(result) {
	console.log(result);
	loaded = true;
}