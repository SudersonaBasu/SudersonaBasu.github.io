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
