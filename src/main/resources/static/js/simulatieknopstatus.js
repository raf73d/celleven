export const aangepast = {
    vpc: false,
    maxLeeftijd: false,
    vpv: false
};

export function controleerKnop() {

    const startKnop =
        document.getElementById("startKnop");

    startKnop.disabled =
        !Object.values(aangepast)
               .every(v => v);
}