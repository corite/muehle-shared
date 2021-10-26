# muehle-client
A java client to play Mühle.
## Setup
### Environment Variables
- `logLevel`: specifies a log-level for Logback (p.e. `INFO`, `WARN` )

## Project Structure
- separate backend and frontend code in different packages
- interaction between them should maybe be defined by a separate interface to ease later migration of the server-side code
