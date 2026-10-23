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
    toongrafiek();
}


async function toongrafiek() {
  const response = await fetch("http://localhost:8080/simulatie/statistieken");

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
