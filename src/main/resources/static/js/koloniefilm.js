const response =
    await fetch("/simulatie/kolonie");

const kolonies = await response.json();

const canvas = document.getElementById("wereld");
const ctx = canvas.getContext("2d");

function teken(cyclus) {

    ctx.clearRect(0, 0, 500, 500);

    cyclus.cellenPosities.forEach(cel => {

        ctx.fillStyle = "limegreen";

        ctx.fillRect(
            cel.x * 50,
            cel.y * 50,
            48,
            48
        );
    });
}

let index = 0;

setInterval(() => {

    teken(kolonies[index]);

    index++;

    if (index >= kolonies.length) {
        index = 0;
    }

}, 300);