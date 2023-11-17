# www.Memorize.com (backend)

## Gruppekontrakt

|                           |          |                                                   |
|---------------------------|:--------:|:--------------------------------------------------:|
| Lotte Face Eliasson       | lott4328 | [GitHub Profile](https://github.com/LotteEliasson) |
| Mikkel Olsen              | mikk39k3 | [GitHub Profile](https://github.com/Selmerr)       |
| Jakob Agger Johannessen   | jako894n | [GitHub Profile](https://github.com/jakobagger)    |
| Hannan Ahmed Mohamad Noor | hann7575 | [GitHub Profile](https://github.com/Hannanxnoor)   |
| Dan Viktor Jørgensen      | danx8076 | [GitHub Profile](https://github.com/davijoe)       |

### Branching Strategy
Our branching strategy incorporates several key elements commonly used in collaborative software development.

We use the <b>'main'</b> branch as our released codebase. For new developments, we create feature branches from our development branch. Once a feature is complete, we initiate a pull request to merge it into the <b>'development'</b> branch. This triggers automated builds and tests via GitHub Actions, and if successful, the changes are deployed to Azure Dev Web App service. When the sprint is complete, we deploy our successfully deployed development branch to our staging branch for further testing. When customer accepts the changes, we merge staging into main.

<b>Key elements in strategy</b>
1. <b>Main Branch (live production)</b><br>
2. <b>Staging Branch (pre-production)</b><br>
3. <b>Development Branch (continous development)</b><br>
4. <b>Feature Branches</b>
5. <b>Pull Requests (Approval required from another team member)</b>
6. <b>Continuous Integration (CI) with GitHub Actions</b>
7. <b>Deployment with Azure Web App Service</b>
8. <b>Merging Staging into Master</b>
