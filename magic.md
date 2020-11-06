# Magic

## Java

### Given a sentence count number of words.
Sentence: The universe is all of space and time and their contents, including planets, stars, galaxies, and all other forms of matter and energy. While the spatial size of the entire universe is unknown, it is possible to measure the size of the observable universe, which is currently estimated to be 93 billion light-years in diameter.

```
List<String> wordsList = Stream.of(sentence)
    .map(s -> s.split("\\s+"))
    .flatMap(Arrays::stream)
    .collect(Collectors.toList());


Map<String, Integer> countOfWords_usingtoMap = wordsList.stream()
    .filter(Objects::nonNull)
    .filter(word -> !word.isBlank())
    .collect(Collectors.toMap(String::toLowerCase, w -> 1, Integer::sum));

Map<String, Integer> countOfWords_usingGroupingBy_summingInt = wordsList.stream()
    .filter(Objects::nonNull)
    .filter(word -> !word.isBlank())
    .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));

Map<String, Long> countOfWords_usingGroupingBy_counting = wordsList.stream()
    .filter(Objects::nonNull)
    .filter(word -> !word.isBlank())
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

System.out.println(countOfWords_usingtoMap);
System.out.println(countOfWords_usingGroupingBy_summingInt);
System.out.println(countOfWords_usingGroupingBy_counting);
```

## Terminal

### Search text in a file or compressed file
```
zgrep -i "<TEXT_TO_SEARCH>" *.gz
grep -Ril "<TEXT_TO_SEARCH>" ./
```

### TCP Dump
```
sudo tcpdump -w captured.pcap -i eth0 host <IP_ADDRESS>
```

### While Condition
```
while true; do sudo netstat | grep <TEST>; sleep 5;done
```
