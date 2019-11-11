# ttl2ignf

A simple utility to translate ttl files into IGraph normal form.

## Installation

Watch this space

## Usage

Possibly edit env/config.edn as

```
{
 :sparql-endpoint "http://path/to/my/endpoint/with/update/privs"
}
```

Or in a console:
```
$ EXPORT SPARQL_ENDPOINT "http://path/to/my/endpoint/with/update/privs"
```
Then 
```
$ java -jar ttl2ignf-0.1.0-standalone.jar <ttl-file> > <destination-file>
```

Or 

```
lein run <ttl-file>  > <destination-file>
```

## License

Copyright © 2019 Eric D. Scott

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
