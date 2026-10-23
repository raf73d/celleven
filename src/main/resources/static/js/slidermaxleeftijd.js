"use strict";


const slider = document.getElementById("maxleeftijd");
const waarde = document.getElementById("waardemaxleeftijd");

slider.addEventListener("input", () => {
    console.log(slider.value);
    waarde.textContent = slider.value;
});

slider.addEventListener("change", async () => {

    await fetch(
        "http://localhost:8080/simulatie/maxleeftijd",
        {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: slider.value
        }
    );
});