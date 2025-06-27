from fastapi import FastAPI

from app.api.endpoint import root_router, api_router
from app.core.config import settings

app = FastAPI(
    title=settings.PROJECT_NAME,
    version=settings.PROJECT_VERSION
)

app.include_router(api_router, prefix=settings.API_V1_STR)
app.include_router(root_router)
