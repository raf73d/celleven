export const aangepast = {
    vpc: false,
    maxLeeftijd: false,
    vpv: false
};

export function controleerKnop() {
console.log(aangepast);
    const startKnop =
        document.getElementById("startKnop");

    startKnop.disabled =
        !Object.values(aangepast)
               .every(v => v);
}