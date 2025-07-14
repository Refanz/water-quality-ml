import uuid

from sqlmodel import SQLModel, Field


class UserDetail(SQLModel, table=True):
    id: uuid.UUID = Field(default_factory=uuid.uuid4, primary_key=True)
    name: str = Field(nullable=False)
