var grid = [];
var gridW = 0;
var gridH = 0;

var reader;

var imgs = [];
var higher = [];
var offset = [];

var loaded = false;

var camX = 0;
var camY = 0;

var selectedTile = 1;

function preload() {
	imgs[1] = loadImage("../core/assets/tiles/grasstile.png");
	higher[1] = false;
	offset[1] = false;
	imgs[2] = loadImage("../core/assets/tiles/watertile.png");
	higher[2] = false;
	offset[2] = false;
	imgs[3] = loadImage("../core/assets/tiles/sandtile.png");
	higher[3] = true;
	offset[3] = true;
	imgs[4] = loadImage("../core/assets/tiles/asphalt.png");
	higher[4] = true;
	offset[4] = true;
}

function setup() {
	this.camX = 0;
	this.camY = 0;

	reader = new FileReader();
	reader.onload = function (progressEvent) {
		importClassDiagramFromJSON(this.result);
	};

	for (let x = 0; x < grid.length; x++) {

	}

	createCanvas(1200, 700);
}

function draw() {
	background(200);

	if (this.loaded) {
		let camTile = getCamTilePos();

		for (let x = max(0, camTile.x); x < min(gridW, camTile.x + 40); x++) {
			for (let y = max(0, camTile.y); y < min(gridH, camTile.y + 40); y++) {
				if (!this.higher[grid[x][y]]) {
					if (this.offset[grid[x][y]]) {
						image(imgs[grid[x][y]], (x - camTile.x) * 32 - 12, (height - 32) - ((y - camTile.y) * 32 + 12), 56, 56);
					}
					if (!this.offset[grid[x][y]]) {
						image(imgs[grid[x][y]], (x - camTile.x) * 32, (height - 32) - ((y - camTile.y) * 32), 32, 32);
					}
				}
			}
		}
		for (let x = max(0, camTile.x); x < min(gridW, camTile.x + 40); x++) {
			for (let y = max(0, camTile.y); y < min(gridH, camTile.y + 40); y++) {
				if (this.higher[grid[x][y]]) {
					if (this.offset[grid[x][y]]) {
						image(imgs[grid[x][y]], (x - camTile.x) * 32 - 12, (height - 32) - ((y - camTile.y) * 32 + 12), 56, 56);
					}
					if (!this.offset[grid[x][y]]) {
						image(imgs[grid[x][y]], (x - camTile.x) * 32, (height - 32) - ((y - camTile.y) * 32), 32, 32);
					}
				}
			}
		}

		let mouseTile = getSelectedPos();

		strokeWeight(2);
		stroke(0);
		noFill();
		rect((mouseTile.x - camTile.x) * 32, (height - (mouseTile.y - camTile.y + 1) * 32), 32, 32);

		image(imgs[selectedTile], 10, 10, 48, 48);
		strokeWeight(5);
		rect(10, 10, 48, 48);

		noStroke();
		fill(0);
	}

	text(floor(frameRate()), 0, 12);
}

function getCamTilePos() {
	let camTileX = floor(camX / 32);
	let camTileY = floor(camY / 32);

	return { x: camTileX, y: camTileY };
}

function getSelectedPos() {
	let camTile = getCamTilePos();

	let mouseTileX = floor(mouseX / 32) + camTile.x;
	let mouseTileY = floor((height - mouseY) / 32) + camTile.y;

	return { x: mouseTileX, y: mouseTileY };
}

function mouseClicked() {
	let pos = getSelectedPos();
	setTile(pos.x, pos.y, selectedTile);
}

function mouseDragged() {
	let pos = getSelectedPos();
	setTile(pos.x, pos.y, selectedTile);
}

function setTile(x, y, tile) {
	if (y >= gridH) {
		for (let i = 0; i < gridW; i++) {
			for (let j = gridH; j <= y; j++) {
				grid[i][j] = 1;
			}
		}
		gridH = y + 1;
	}

	if (x >= gridW) {
		for (let i = gridW; i <= x; i++) {
			grid[i] = [];
			for (let j = 0; j < gridH; j++) {
				grid[i][j] = 1;
			}
		}
		gridW = x + 1;
	}

	grid[x][y] = tile;
}

function keyPressed() {
	if (key == "W") {
		this.camY += 32;
	} else if (key == "S") {
		this.camY -= 32;
	} else if (key == "A") {
		this.camX -= 32;
	} else if (key == "D") {
		this.camX += 32;
	}
}

function mouseWheel(event) {
	if (event.delta > 0) {
		selectedTile++;
		if (selectedTile >= imgs.length) {
			selectedTile = 1;
		}
	} else {
		selectedTile--;
		if (selectedTile <= 0) {
			selectedTile = imgs.length - 1;
		}
	}
}

function newFile() {
	var file = document.getElementById('file-input').files[0];
	reader.readAsText(file);
}

function importClassDiagramFromJSON(result) {
	this.grid = [];
	this.gridW = 0;
	this.gridH = 0;
	let y = 0;
	for (let line of result.split("\n")) {
		let x = 0;
		for (let thingy of line.split(",")) {
			this.gridW = this.Math.max(x + 1, gridW);
			if (grid.length < gridW) {
				grid[x] = [];
			}
			this.grid[x][y] = Number.parseInt(thingy);
			x++;
		}
		y++;
	}
	this.gridH = y;

	console.log(grid);

	this.loaded = true;
}

function exportGrid() {
	var textToWrite = "";

	for(let y = 0; y < gridH; y++){
		for(let x = 0; x < gridW; x++){
			textToWrite += grid[x][y] + ",";
		}
		textToWrite = textToWrite.substring(0, textToWrite.length - 1);
		textToWrite += "\n";
	}
	textToWrite = textToWrite.substring(0, textToWrite.length - 1);

	var textFileAsBlob = new Blob([textToWrite], { type: 'text/plain' });
	var fileNameToSaveAs = "world.txt";
	var downloadLink = document.createElement("a");
	downloadLink.download = fileNameToSaveAs;
	downloadLink.innerHTML = "Download File";
	if (window.webkitURL != null) {
		// Chrome allows the link to be clicked
		// without actually adding it to the DOM.
		downloadLink.href = window.webkitURL.createObjectURL(textFileAsBlob);
	}
	else {
		// Firefox requires the link to be added to the DOM
		// before it can be clicked.
		downloadLink.href = window.URL.createObjectURL(textFileAsBlob);
		downloadLink.style.display = "none";
		document.body.appendChild(downloadLink);
	}

	downloadLink.click();
}