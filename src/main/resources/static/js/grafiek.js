"use strict";
import { byId, toon, verberg, setText } from "./util.js";

let chart;
verberg("myChart", "statusChart");
toon("statusChart");

document.addEventListener("DOMContentLoaded", () => {
  const startKnop = document.getElementById("startKnop");

  startKnop.addEventListener("click", startSimulatie);
});

async function startSimulatie() {
  await toongrafiek();
  const response = await fetch("/simulatie/kolonie");

  const kolonies = await response.json();

  startAnimatie(kolonies);
}
let timerId = null;

function startAnimatie(kolonies) {
  const canvas = document.getElementById("wereld");
  const ctx = canvas.getContext("2d");

  let index = 0;

  // Vorige animatie stoppen
  if (timerId) {
    clearInterval(timerId);
  }

  timerId = setInterval(() => {
    const cyclus = kolonies[index];
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.fillStyle = "#f2f2f2";
    ctx.fillRect(0, 0, canvas.width, 40);
    ctx.fillStyle = "black";
    ctx.font = "20px Arial";
    ctx.fillText(`Cycle ${cyclus.cycle}`, 10, 25);
    for (let x = 0; x < 10; x++) {
      for (let y = 0; y < 10; y++) {
        ctx.strokeStyle = "#cccccc";

        ctx.strokeRect(x * 30, y * 30 + 40, 30, 30);
      }
    }

    cyclus.cellenPosities.forEach((cel) => {
      ctx.fillStyle = "limegreen";

      ctx.fillRect(cel.x * 30 + 2, cel.y * 30 + 42, 26, 26);
    });

    index++;

    if (index >= kolonies.length) {
      clearInterval(timerId);
    }
  }, 300);
}

async function toongrafiek() {
  const response = await fetch(`/simulatie/statistieken`);

  if (response.ok) {
    const ranglijst = await response.json();
    if (ranglijst.length === 0) {
      toon("mededelingChart");
      verberg("myChart");
    } else {
      verberg("statusChart");
      toon("myChart");
      const ctx = byId("myChart");
      if (chart) {
        chart.destroy();
      }
      chart = new Chart(ctx, {
        type: "line",
        data: {
          labels: ranglijst.map((r) => r.cycle),
          datasets: [
            {
              label: "Aantal cellen",
              data: ranglijst.map((r) => r.aantal),
              borderColor: "blue",
            },
            {
              label: "Minimum",
              data: ranglijst.map((r) => r.min),
              borderColor: "green",
            },
            {
              label: "Maximum",
              data: ranglijst.map((r) => r.max),
              borderColor: "red",
            },
            {
              label: "Gemiddelde",
              data: ranglijst.map((r) => r.gemiddelde),
              borderColor: "orange",
            },
          ],
        },
        options: {
          responsive: true,
          scales: {
            y: {
              beginAtZero: true,
            },
          },
        },
      });
    }
  }
}
