"use strict";

console.log("slider geladen");

const slider = document.getElementById("vpv");
const waarde = document.getElementById("waardevpv");

slider.addEventListener("input", () => {
    console.log(slider.value);
    waarde.textContent = slider.value;
});

slider.addEventListener("change", async () => {

    await fetch(
        `/simulatie/verouderingpervoortplanting`,
        {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: slider.value
        }
    );
});