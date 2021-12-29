# typo-corrector

## Viikkoraportit:

[Viikko 1](https://github.com/juhkure/typo-corrector/blob/main/dokumentaatio/viikko%201.txt)

[Viikko 2](https://github.com/juhkure/typo-corrector/blob/main/dokumentaatio/viikko%202.txt)

[Viikko 3](https://github.com/juhkure/typo-corrector/blob/main/dokumentaatio/viikko%203.txt)

[Viikko 4-5](https://github.com/juhkure/typo-corrector/blob/main/dokumentaatio/viikko%204-5.txt)


[Projektisuunnitelma](https://github.com/juhkure/typo-corrector/blob/main/dokumentaatio/projektisuunnitelma.txt)


[Testausdokumentti](https://github.com/juhkure/typo-corrector/blob/main/dokumentaatio/testausdokumentti.txt)

[Toteutusdokumentti](https://github.com/juhkure/typo-corrector/blob/main/dokumentaatio/toteutusdokumentti)

## Tiedostorakenne
```

├── src
│   └── main
│       └── java
│           ├── sanakirja
│           │   ├── Dictionary.java
│           │   ├── Trie.java
│           │   └── TrieNode.java
│           └── typo
│               └── corrector
│                   └── Main.java
├── resources
│   └── word.txt
├── test
│   └── java
│       ├── DictionaryTest.java
│       └── TrieTest.java
```


Käytössä Gradle: 

$ gradle run


Testit sekä rivi- ja haaraumakattavuus jacocolla: 

$ gradle test

ja

$ gradle jacocoTestReport
