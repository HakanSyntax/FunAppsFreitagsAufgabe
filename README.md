# iTunes Suche mit Detailansicht

Die Firma "MusicExplorer" möchte ihre bestehende iTunes App erweitern und dem User mehr Informationen bieten.

<p align="center">
<img src=img/img1.png width="25%">
&nbsp; &nbsp; &nbsp; 
<img src=img/img2.png width="25%">
</p>

## Arbeitsauftrag

Du wirst mit dem Umbau der App beauftragt. Die App funktioniert bereits und lädt die Infos per API Call von der [**iTunes Search API**](https://developer.apple.com/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/index.html).  
Momentan wird einfach nur eine simple Liste angezeigt, das Ziel ist jedoch, dass die UI am Ende so aussieht wie auf den Screenshots

---

### 1. Dokumentation verstehen

Lies dir die Dokumentation der [**iTunes Search API**](https://developer.apple.com/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/index.html) noch einmal aufmerksam durch und schau dir insbesondere die API Antwort an und was für Informationen geliefert werden
> Hinweis: Du kannst dir die Seite auch auf Deutsch oder in eine andere Sprache übersetzen lassen.

---

### 2. Die App umbauen

Baue die App um:

- Erweitere das Datenmodell, sodass alle Informationen der API empfangen werden
- In der Liste aus Suchergebnissen sollen die Bilder mit angezeigt werden
- In der Liste aus Suchergebnissen soll die Dauer des Tracks angezeigt werden (Hinweis: du bekommst die Dauer in Millisekunden übergeben)
- Bei einem Klick auf einen Listeneintrag soll in ein DetailFragment navigiert werden
- Im Detailfragment sollen alle wichtigen Informationen angezeigt werden. Orientiere dich an dem Screenshot
- Im Detailfragment sollen die Ecken des Bildes mithilfe von `Coil` abgerundet sein

> Hinweis: Im gradle sind bereits alle Dependencies enthalten die du brauchst

Viel Erfolg! 🚀
