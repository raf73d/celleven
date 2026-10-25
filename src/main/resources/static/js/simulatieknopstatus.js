import { byId, toon, verberg, setText } from "./util.js";

export const aangepast = {
    vpc: false,
    maxLeeftijd: false,
    vpv: false
};

export function controleerKnop() {
console.log(aangepast);
    const startKnop =
        byId("startKnop");

    const enabled =
        Object.values(aangepast).every(v => v);

    startKnop.disabled = !enabled;

    if (enabled) {
        verberg("knopStatus");
    } else {
        toon("knopStatus");
    }
}