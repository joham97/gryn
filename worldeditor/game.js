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

function getCamTilePos(){
	let camTileX = floor(camX / 32);
	let camTileY = floor(camY / 32);

	return {x: camTileX, y: camTileY};
}

function getSelectedPos(){
	let camTile = getCamTilePos();

	let mouseTileX = floor(mouseX / 32) + camTile.x;
	let mouseTileY = floor((height - mouseY) / 32) + camTile.y;

	return {x: mouseTileX, y: mouseTileY};
}

function mouseClicked(){
	let pos = getSelectedPos();
	setTile(pos.x, pos.y, selectedTile);
}

function mouseDragged(){
	let pos = getSelectedPos();
	setTile(pos.x, pos.y, selectedTile);
}

function setTile(x, y, tile){
	if(x >= gridW){
		for(let i = gridW; i <= x; i++){
			grid[i] = [];
			for(let j = 0; j < gridH; j++){
				grid[i][j] = 1;
			}
		}
		gridW = x;
	}
	
	if(y >= gridH){
		for(let i = 0; i < gridW; i++){
			for(let j = gridH; j <= y; j++){
				grid[i][j] = 1;
			}
		}
		gridW = x;
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
	if(event.delta > 0){
		selectedTile++;
		if(selectedTile >= imgs.length){
			selectedTile = 1;
		}
	}else{
		selectedTile--;
		if(selectedTile <= 0){
			selectedTile = imgs.length - 1;
		}
	}
}

function newFile() {
	var file = document.getElementById('file-input').files[0];
	reader.readAsText(file);
}

function importClassDiagramFromJSON(result) {
	gridW = 0;
	for (let thingy of result.split("\n")[0].split(",")) {
		this.grid[gridW] = [];
		gridW++;
	}

	gridH = 0;
	for (let line of result.split("\n")) {
		let x = 0;
		for (let thingy of line.split(",")) {
			this.grid[x][gridH] = Number.parseInt(thingy);
			x++;
		}
		gridH++;
	}

	this.loaded = true;
}