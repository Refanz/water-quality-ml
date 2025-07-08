from fastapi import FastAPI

from app.core.config import settings
from app.infrastructure.api.endpoint import api_router, root_router

app = FastAPI(
    title=settings.PROJECT_NAME,
    version=settings.PROJECT_VERSION
)

app.include_router(api_router, prefix=settings.API_V1_STR)
app.include_router(root_router)
