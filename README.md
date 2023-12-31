# Exercice Okayo #
Le but de cet exercice est de décrire le modèle de données relationnel qui serait lié à la gestion de factures. Il s’agit de créer des factures, les stocker et pouvoir les visualiser en détail. Pour cela on doit pouvoir traiter des paramètres qui seraient préalablement stockés (taux de TVA sur une période
donnée, base client, base catalogue des éléments désignés en ligne sur les factures, ...).
Pour cela on fait les hypothèses suivantes :
• Une fois la facture établie à une date donnée, et à chaque consultation, le TTC devra être
systématiquement le même, indépendamment des évolutions de tarif des produits du catalogue.
• Les noms et les prix des prestations pourront éventuellement évoluer dans le catalogue, mais doivent
être évidemment rester inchangés sur les factures déjà existantes
• La TVA peut changer au fur et à mesure du temps et peut être différente pour chaque produit du
catalogue. Il est possible que celle-ci doive évoluer à une date précise ou pour une période donnée.
