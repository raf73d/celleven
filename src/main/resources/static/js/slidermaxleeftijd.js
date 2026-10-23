"use strict";
import { aangepast, controleerKnop } from "./simulatieknopstatus.js";

const slider = document.getElementById("maxleeftijd");
const waarde = document.getElementById("waardemaxleeftijd");

slider.addEventListener("input", () => {
  console.log(slider.value);
  waarde.textContent = slider.value;
});

slider.addEventListener("change", async () => {
  aangepast.maxLeeftijd = true;

  controleerKnop();
  await fetch(`/simulatie/maxleeftijd`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: slider.value,
  });
});


