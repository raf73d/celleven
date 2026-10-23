"use strict";
import {
    aangepast,
    controleerKnop
} from "./simulatieknopstatus.js";
console.log("slider geladen");

const slider = document.getElementById("vpc");
const waarde = document.getElementById("waarde");

slider.addEventListener("input", () => {
    console.log(slider.value);
    waarde.textContent = slider.value;
});

slider.addEventListener("change", async () => {
aangepast.vpc = true;

    controleerKnop();
    await fetch(
        `/simulatie/verouderingpercycle`,
        {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: slider.value
        }
    );
});