# 📊 Visual Flow – Active Connection Points Pause/Resume

```mermaid
flowchart TD
    A[Launch ION Application] --> B[Navigate to Active Connection Points]
    B --> C[Select a Connection Point]

    C --> D{User Action}
    D -->|Check Sending Paused| E[UI: Checkbox Checked\nBackend: Sent halted\nSent count frozen]
    D -->|Uncheck Sending Paused| F[UI: Checkbox Unchecked\nBackend: Sent resumes\nSent count increases]
    D -->|Check Receiving Paused| G[UI: Checkbox Checked\nBackend: Received halted\nPending increases]
    D -->|Uncheck Receiving Paused| H[UI: Checkbox Unchecked\nBackend: Received resumes\nPending decreases]

    E --> I[Refresh Page]
    F --> I
    G --> I
    H --> I

    I --> J[States Persist After Refresh]
    J --> K[Navigate Away & Return]
    K --> L[States Remain Consistent]
    L --> M[Backend API Calls Match User Actions]
