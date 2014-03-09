# DescriptiveStatistics ![Build Status](https://secure.travis-ci.org/nickmcdonnough/descriptivestatistics.png)

A Clojure library for calculating [descriptive statistics](http://en.wikipedia.org/wiki/Descriptive_statistics). This is a port of Derrick Parkhurst's Ruby gem which can be viewed [here](https://github.com/thirtysixthspan/descriptive_statistics).
## Usage
```
descriptivestatistics.core=> (mean [1 2 3 4])
2.5
descriptivestatistics.core=> (variance [1 2 3 4])
1.25
descriptivestatistics.core=> (standard-deviation [1 2 3 4])
1.118033988749895
descriptivestatistics.core=> (percentile-from-value [1 2 3 4 5] 4)
60.0
```
## License

MIT

#### Contact
nickmcd [at] gmail