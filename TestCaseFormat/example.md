**Feature:** Active Connection Points – Pause/Resume Functionality  

---

## 🎯 Objective
- Validate the stability and persistence of **Sending Paused** and **Receiving Paused** checkboxes.  
- Ensure UI actions (pause/resume, refresh, navigation) are consistently reflected in the backend API and runtime counters.  
- Confirm that rapid or repeated user interactions do not cause mismatched states or duplicate API calls.  

---

## 📦 Scope
- **In-Scope:**  
  - UI validation of pause/resume checkboxes.  
  - Backend API call verification.  
  - Runtime counters (Sent, Received, Pending).  
  - Page refresh and navigation consistency.  
- **Out-of-Scope:**  
  - Non-ION connectors.  
  - Performance benchmarking beyond pause/resume flows.  
  - Security or authentication testing.  

---

## 📊 Test Data
- **Connection Points (CPs):**  
  - Enterprise Connector CP  
  - Network CP  
  - File CP  
  - Stream CP  
  - sFTP via Cloud CP  

- **States:**  
  - Active  
  - Paused (Sending/Receiving)  
  - Pending  

- **Counters:**  
  - Sent  
  - Received  
  - Pending  
  - No Route  

- **Actions:**  
  - Pause  
  - Resume  
  - Refresh  
  - Navigate Away/Return  


---

## 🧪 Test Scenarios

| Scenario ID | Description | Steps | Expected Result |
|-------------|-------------|-------|-----------------|
| TS-01 | Validate Sending Paused | Check → Uncheck Sending Paused | UI reflects state; Sent counter frozen/resumes correctly |
| TS-02 | Validate Receiving Paused | Check → Uncheck Receiving Paused | UI reflects state; Received counter frozen/resumes; Pending adjusts |
| TS-03 | Persistence After Refresh | Pause → Refresh Page | Checkbox state persists; backend unchanged |
| TS-04 | Persistence After Navigation | Pause → Navigate Away → Return | State remains consistent |
| TS-05 | Rapid Toggle Stress Test | Rapidly toggle Sending/Receiving | UI reflects each action; no duplicate/conflicting API calls |
| TS-06 | Backend Verification | Perform pause/resume actions | API calls match user actions; counters align |
| TS-07 | Negative Scenario | Auto-refresh disabled | Filters remain intact; no unexpected refreshes |

---
