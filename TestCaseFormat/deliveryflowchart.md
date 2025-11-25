# 📊 Deployment & Release Process Flowchart

```mermaid
flowchart TD
    A[Deployment Schedule] --> B{Environment}
    B --> C[CI: Daily Integration]
    B --> D[T20: Sprint Testing Monthly]
    B --> E[IGS: Bi-Monthly Testing]
    B --> F[CQA: Integration Testing]
    B --> G[Stage: Pre-Production Verification]
    B --> H[Production: Major Releases Twice a Year]

    H --> I[Release Process (AWS)]
    I --> J[Pre-Deployment Setup]
    J --> K[Track Backport Requests]
    J --> L[Create DEVINT Tickets]
    J --> M[Add Stakeholders & Summary]

    I --> N[Release Tracking]
    N --> O[Update Release Tickets]
    N --> P[Attach Test Results]
    N --> Q[Deployment Details]

    I --> R[Build & Deployment]
    R --> S[Build Finalization in Jenkins]
    R --> T[Deployment to CQA]
    R --> U[Stage Deployment]

    U --> V{Issues Found?}
    V -->|Yes| W[Escalate to Dev Teams & Governance]
    V -->|No| X[Proceed to Production]

    X --> Y[IGS Releases (Even Numbers)]
    Y --> Z[Additional IGS Deployments]
    Z --> AA[TRAIN Ticket Creation]
    Z --> AB[Governance & PMO Approvals]

    X --> AC[Supplementary Updates]
    AC --> AD{Planned or Unplanned?}
    AD --> AE[Planned SU: Follow Standard Process]
    AD --> AF[Unplanned SU: Urgent Fixes, NewRC]

    X --> AG[Critical Fixes]
    AG --> AH{Issue Type}
    AH --> AI[Hotfix: Single Component]
    AH --> AJ[Full Release: Multiple Components]
    AJ --> AK[Governance Approval & Redeployment]

    X --> AL[Post-Release Steps]
    AL --> AM[Download SBOMs]
    AM --> AN[Verify Build Versions]
    AN --> AO[Upload to SBOM Registry]
