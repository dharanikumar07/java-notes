## 1. Main Data Types

| Type          | Purpose                                     | Example                     |
| ------------- | ------------------------------------------- | --------------------------- |
| `DATE`        | Date only                                   | `2026-10-13`                |
| `TIME`        | Time only                                   | `18:30:00`                  |
| `TIMESTAMP`   | Date + time, no timezone                    | `2026-10-13 18:30:00`       |
| `TIMESTAMPTZ` | Date + time representing a specific instant | `2026-10-13 18:30:00+05:30` |
| `BOOLEAN`     | True / False                                | `TRUE`                      |

## 2. TIMESTAMP vs TIMESTAMPTZ

**TIMESTAMP**

- Stores date and time without timezone information.
    
- No automatic timezone conversion.
    

**TIMESTAMPTZ**

- Represents a specific point in time.
    
- PostgreSQL converts input to UTC internally.
    
- Displays the value in the session's timezone when retrieved.
    

**Example:** The same instant can display as `6:00 PM` in one timezone and `12:30 PM` in UTC.

## 3. Best Practices

- Use `TIMESTAMPTZ` for events that happen at a specific instant.
    
- Use `DATE` for birthdays and calendar dates.
    
- Use `TIME` for time of day without a date.
    
- Use `TIMESTAMP` for date/time values that do not represent a timezone-specific instant.
    
- Prefer storing and processing instants consistently; convert to local time for display.
    
- Avoid splitting one event's date and time into separate columns unless required by the use case.
    

## Remember

- `DATE` → Date only
    
- `TIME` → Time only
    
- `TIMESTAMP` → Date + time, no timezone
    
- `TIMESTAMPTZ` → Specific instant, timezone-aware conversion
    
- `BOOLEAN` → `TRUE` or `FALSE`