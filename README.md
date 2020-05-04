# network-programming

Изисквания:
- Java 8 (или по-нова версия)

Стартирането е стандартно за всяко конзолно Java приложение.  
Инструкции(Ubuntu):
1. Стартираме терминалът  
``(Ctrl + Alt + T)``
2. Придвижваме се към сорс кода на проекта.  
``cd network-programming/spam-blacklist-check/src``
3. Компилираме проекта  
``javac com/valentinvstoqnov/*.java``
4. Стартираме го като подаваме аргументи.  
``java com.valentinvstoqnov.SpamhausChecker 127.0.0.2``  
5. Резултат  
``The IP address: 127.0.0.2 is found in the following Spamhaus public IP zone:``  
``'127.0.0.2 - SBL - Spamhaus SBL Data'``  
``'127.0.0.4 - XBL - CBL Data'``  
``'127.0.0.10 - PBL - ISP Maintained'``  
