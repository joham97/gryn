var grid = [];

var reader;

var imgs = [];
var higher = [];
var offset = [];

var loaded = false;

var camX = 0;
var camY = 0;

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
		let centerTileX = floor(camX / 32);
		let centerTileY = floor(camY / 32);
		for (let x = max(0, centerTileX); x < min(grid.length, centerTileX + 40); x++) {
			for (let y = max(0, centerTileY); y < min(grid[x].length, centerTileY + 40); y++) {
				if (!this.higher[grid[x][y]]) {
					if (this.offset[grid[x][y]]) {
						image(imgs[grid[x][y]], (x - centerTileX) * 32 - 12, (y - centerTileY) * 32 - 12, 32, 32);
					}
					if (!this.offset[grid[x][y]]) {
						image(imgs[grid[x][y]], (x - centerTileX) * 32, (y - centerTileY) * 32, 32, 32);
					}
				}
			}
		}
		for (let x = max(0, centerTileX); x < min(grid.length, centerTileX + 40); x++) {
			for (let y = max(0, centerTileY); y < min(grid[x].length, centerTileY + 40); y++) {
				if (this.higher[grid[x][y]]) {
					if (this.offset[grid[x][y]]) {
						image(imgs[grid[x][y]], (x - centerTileX) * 32 - 12, (y - centerTileY) * 32 - 12, 56, 56);
					}
					if (!this.offset[grid[x][y]]) {
						image(imgs[grid[x][y]], (x - centerTileX) * 32, (y - centerTileY) * 32, 56, 56);
					}
				}
			}
		}
	}
}

function newFile() {
	var file = document.getElementById('file-input').files[0];
	reader.readAsText(file);
}

function importClassDiagramFromJSON(result) {
	let c = 0;
	for (let thingy of result.split("\n")[0].split(",")) {
		this.grid[c] = [];
		c++;
	}

	let y = 0;
	for (let line of result.split("\n")) {
		let x = 0;
		for (let thingy of line.split(",")) {
			this.grid[x][y] = Number.parseInt(thingy);
			x++;
		}
		y++;
	}

	this.loaded = true;
}

function keyPressed(){
	if(key == "W"){
		console.log("W");
	}else if(key == "S"){

	}else if(key == "A"){

	}else if(key == "D"){

	}
	
}