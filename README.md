Celleven

Celleven is een simulatie van een kolonie cellen die leeft op een raster van 10 × 10 vakken.

De simulatie start steeds met vier cellen. Tijdens elke cyclus verouderen de cellen en kunnen naburige cellen zich voortplanten door nieuwe cellen te creëren op vrije plaatsen in hun omgeving. Voortplanting heeft echter een prijs: elke reproductie versnelt het verouderingsproces van de betrokken cellen.

Daarnaast beïnvloedt ook de grootte van de kolonie haar overlevingskansen. Naarmate de populatie groeit, neemt de druk op de kolonie toe en verkort de levensduur van de cellen.

Met behulp van verschillende parameters kan worden onderzocht hoe een kolonie zich ontwikkelt:

	Veroudering per cyclus
	Veroudering per voortplanting
	Maximale leeftijd

Afhankelijk van deze instellingen kan een kolonie snel uitsterven, een stabiel evenwicht bereiken of explosief groeien voordat ze instort.

De applicatie toont zowel:

	een statistische grafiek van de populatieontwikkeling;
	een realtime visualisatie van de kolonie op het raster;
	de evolutie van de populatie doorheen de verschillende cycli.

Architectuur

De simulatie maakt gebruik van het Observer Design Pattern. De leefwereld fungeert als subject en verwittigt de aanwezige cellen bij iedere nieuwe cyclus. Elke cel reageert zelfstandig op deze notificatie door haar leeftijd aan te passen en te bepalen of zij de cyclus overleeft.

Deze aanpak zorgt voor een losse koppeling tussen de leefwereld en de individuele cellen en maakt het model eenvoudig uitbreidbaar.

Technologieën

	Java 21
	Spring Boot
	REST API
	Bootstrap 5
	Chart.js
	HTML5 Canvas
	Observer Design Pattern
	Render Cloud Deployment
