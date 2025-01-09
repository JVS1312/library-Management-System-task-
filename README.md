# library-Management-System-task-


## Database Management System:
- **PostgreSQL**

## Programming Language:
- **Java with JDBC API**
---

## Tables

### Authors Table

This table stores information about the authors.

| Field     | Type           | Nullable | Description                                      |
|-----------|----------------|----------|--------------------------------------------------|
| `id`      | `SERIAL`       | No       | The unique identifier for each author. Auto-incremented. |
| `name`    | `VARCHAR(255)`  | Yes      | The name of the author. Can be NULL.             |

### Books Table

This table stores information about books. It has a foreign key relationship with the authors table.

| Field      | Type           | Nullable | Description                                      |
|------------|----------------|----------|--------------------------------------------------|
| `id`       | `SERIAL`       | No       | The unique identifier for each book. Auto-incremented. |
| `title`    | `VARCHAR(255)`  | No       | The title of the book.                          |
| `author_id`| `INT`          | Yes      | The foreign key referencing the author's `id` from the authors table. |

---

### Relationships:
- The `books` table has a **foreign key** relationship with the `authors` table. The `author_id` field in the `books` table references the `id` field in the `authors` table.
