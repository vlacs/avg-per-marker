# avg-per-marker
Read stdin for [elapsed-time marker] pairs, and print out stats about the elapsed times every time the marker changes.

Here's some sample input:
```text
0.161192 Mon-Mar-24-15:39
0.056217 Mon-Mar-24-15:39
0.160669 Mon-Mar-24-15:40
0.533983 Mon-Mar-24-15:40
```

cat sample-input.txt into this program to see sample output:
```bash
$ cat sample-input.txt | lein run
Mon-Mar-24-15:39 {:count 727, :total-elapsed-time 235.48438481986523, :average-elapsed-time 0.3239124963134322}
Mon-Mar-24-15:40 {:count 1644, :total-elapsed-time 473.59876988083124, :average-elapsed-time 0.28807711063310903}
```


## Examples

```bash
$ tail -f /some/log/file | sed <substitute some stuff to create necessary "n marker" format> | java -jar avg-per-min-0.1.0-standalone.jar
```
### Bugs
* Always throws away any old out-of-order markers after the change to a new marker.

## License

Copyright © 2014 VLACS

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
