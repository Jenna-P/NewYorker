
# UC_Lav nyt tilbud (Iteration 1)

UseCase navn | UC Lav nyt tilbud | 
-------------| -------------------------------| 
Scope        | New Yorker
Primary Actor| Tømrer/Kunder
Level        | User-goal
Description  | Systemet skal kunne modtage angivelse af størrelse på den ønskede væg, udregne og præsentere en skitse, beregne et færdigt tilbud på væggen samt sende disse til kunden og producenten på email. 
Stakeholders and Interests  | Byens Vinduer/New-Yorker.dk
Preconditions  | Den android enhed er tændt.<br> Applikationen er installeret og klar til at bruge.
Succes Guarantee  |  Der er oprettet et gyldigt tilbud og det er sendt til kunden og producenten 
Main Succes Scenario  | 1. Brugeren starter oprettelse af nyt tilbud. <br> 2. Systemet viser indtastnings mulighederne for en ny væg. <br> 3. Brugeren indtaster væggens højde og bredde. <br> 4. Systemet beregner antallet af lodrette ruder ud fra at højde skal ligge så tæt på 60 cm som muligt.<br> 5. Systemet beregner antallet af fag, ud fra at bredden på ruderne skal ligge så tæt på 45 cm som muligt.<br> 6. Systemet genererer skitsen med det beregnede antal ruder og fag.<br>7. Systemet opdaterer prisen ud fra den indtastede højde/bredde og de beregnede antal ruder og fag.<br> 8. Systemet viser væg design og tilbudsprisen.<br> 9. Brugeren bekræfter den viste væg design og tilbudsprisen.<br> 10. Systemet viser kontaktformularen til indtastning af kundeinformation.<br> 11. Brugeren angiver navn, email og telefonnummer.<br> 12. Systemet laver e mail og sender med vedhæftede tilbud samt skitse.
Extensions  | 3a. Mangler at udfylde information om højde.<br> 1. System oplyser om fejl og afventer brugerinput. Processen fortsætter ved punkt 3.<br> <br> 3b.  Hvis brugeren angiver negativ tal om højde.<br> 1. System oplyser om fejl og afventer brugerinput. Processen fortsætter ved punkt 3.<br> <br> 3c. Hvis brugeren angiver højden mere end 250 cm.<br> 1. Systemet oplyser at max højde er 250 cm og afventer brugerinput. Processen fortsætter ved punkt 3.<br> <br> 5a. Mangler at udfylde information om bredde.<br> 1. System oplyser om fejl og afventer brugerinput. Processen fortsætter ved punkt 5.<br> <br> 5b. Hvis brugeren angiver negativ tal om bredde.<br> 1. System oplyser om fejl og afventer brugerinput. Processen fortsætter ved punkt 5.<br><br> 5c. Hvis brugeren angiver bredden mere end 150 cm.<br> 1. Systemet oplyser at væggen vil blive sammensat af flere elementer. Processen fortsætter ved punkt 5.<br><br> 9a. Hvis brugeren ikke bekræfter tilbuddet.<br> 1. Forløbet starter forfra ved punkt 1.
Special Requirements  | --
Technology and Data Variations List  | --
Frequency of Occurrence  | Use casen forekommer ved oprettelse af en designe væg
Miscellaneous  | --
