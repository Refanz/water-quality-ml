from fastapi import FastAPI

from app.api.endpoint import router

app = FastAPI()

app.include_router(router, prefix="/api")